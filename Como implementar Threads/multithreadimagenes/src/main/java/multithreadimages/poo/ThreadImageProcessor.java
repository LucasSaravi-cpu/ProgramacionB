package multithreadimages.poo;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

/**
 * Referencias: 
 * https://stackoverflow.com/questions/238036/java-html-parsing
 * https://stackoverflow.com/questions/30731045/generate-thumbnail-in-java
 * https://docs.oracle.com/javase/tutorial/uiswing/concurrency/index.html
 */

public class ThreadImageProcessor extends Thread
{
    private String threadName;
	private URL url;
    private MainWindow window;
    private Set<URL> urlImgList;
    private JButton buttonImg;
   //private URL currentURL;
    private int addedImages;
    
    final Runnable doProcessImages = new Runnable() {
      public void run() {
    	  JPanel panelImg = new JPanel();
    	  BorderLayout vl = new BorderLayout(1,1);
    	  panelImg.setLayout(vl);

    	  panelImg.add(buttonImg, BorderLayout.CENTER);
    	  JLabel lblThread = new JLabel(threadName + " (" + addedImages + ")" );
    	  lblThread.setHorizontalAlignment(SwingConstants.CENTER);
    	  panelImg.add(lblThread, BorderLayout.SOUTH);
          window.panel.add(panelImg);
          window.panel.revalidate();
      }
    };
    		
    		
    public ThreadImageProcessor(String threadName, URL htmlPage, MainWindow window) throws IOException
    {
        this.threadName = threadName;
    	this.url = htmlPage;	
        this.window = window;
        this.urlImgList = new HashSet<URL>(); 
        addedImages = 0;
    }
    
    
	@Override
	public void run() {
	      try {
	          HtmlCleaner cleaner = new HtmlCleaner();
	          TagNode rootNode = cleaner.clean(url);
	          System.out.println("Thread " + threadName + " -> " + "Buscando imagenes en URL " + url.toString());
	          URLConnection urlConnection = url.openConnection();
	          HttpURLConnection connection = null;
	          if(urlConnection instanceof HttpURLConnection) {
	             connection = (HttpURLConnection) urlConnection;
	             TagNode divElements[] = rootNode.getElementsByName("img", true);
	             for (int i = 0; divElements != null && i < divElements.length; i++)
	             {
	            	 String hrefContent = divElements[i].getAttributeByName("src");
	                 if (hrefContent != null && (hrefContent.contains("jpg") || hrefContent.contains("JPG") || hrefContent.contains("PNG") || hrefContent.contains("png"))) 
	                 {
	                	 if (!hrefContent.startsWith("https://")) {
	                		 hrefContent = url.toString().trim() + hrefContent.trim();
	                	 }
                		 urlImgList.add(new URL(hrefContent));
	                 }
	             }
	             System.out.println("Thread " + threadName + " -> " + urlImgList.size() + " imagenes encontradas");
	
	          }
	          else {
	             System.out.println("Ingrese una URL v�lida.");
	             return;
	          }
	          
	          addedImages = 0;
	          System.out.println("Thread " + threadName + " -> " + "Procesando imagenes");
	          
	          for (URL url : urlImgList) {
	        	  addImage(url);
	          }
	          
	          System.out.println("Thread " + threadName + " -> " + "Finalizado");
	      }	      
	      catch (IOException e) {
		         e.printStackTrace();
	      }
	}

	private void addImage(URL url) {
  	  try {
	    		window.setImgQty(window.getImgQty() + 1);
	    		//window.textArea.append(" " + window.getImgQty());
	    		System.out.println(url.toString() + " -> host: " + url.getHost() + "   port: " + url.getPort() + "   protocol: " + url.getProtocol());		    		
	    		BufferedImage originalImage = ImageIO.read(url);
	            if (originalImage != null) {
		    	    createThumb(originalImage, 160, 160, url);        		            	
		    		SwingUtilities.invokeLater(doProcessImages);
		    		addedImages++;
		            System.out.println("Thread " + threadName + " -> " + addedImages + " imagen(es) agregada(s)");
	            }
      	}
      	catch (Exception e) {
      		System.out.println("Error: " + e.getMessage());
      	}
	}
	private JButton createThumb(BufferedImage in, int newWidth, int newHeight, final URL url) {
        // scale w, h to keep aspect constant
        double outputAspect = 1.0*newWidth/newHeight;
        double inputAspect = 1.0*in.getWidth()/in.getHeight();
        if (outputAspect < inputAspect) {
            // width is limiting factor; adjust height to keep aspect
            newHeight = (int)(newWidth/inputAspect);
        } else {
            // height is limiting factor; adjust width to keep aspect
            newWidth = (int)(newHeight*inputAspect);
        }
        BufferedImage bi = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bi.createGraphics();
        g2.setRenderingHint(
            RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(in, 0, 0, newWidth, newHeight, null);
        g2.dispose();
        buttonImg = new JButton(new ImageIcon(bi)); 
        buttonImg.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
				    Desktop.getDesktop().browse(url.toURI());
				} catch (Exception exc) {exc.printStackTrace();}
			}
        });
        return buttonImg;
    }
	
}