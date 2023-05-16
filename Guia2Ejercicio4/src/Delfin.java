class Delfin extends Animal implements Nadador {
	
    public Delfin(String especie, String grupo) {
        super(especie, grupo);
    }

    @Override
    public void nadar() {
        System.out.println("El delfín de la especie " + super.getEspecie() + " está nadando");
    }
}