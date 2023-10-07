--Coberturas médicas	
SELECT medicalassurance, name FROM medicalassurance


--Medicamentos	
SELECT medicine, description, unitprice FROM medicine

--Pacientes	
SELECT patient, name, birthdate, medicalassurance FROM patient

--Prescripciones	
SELECT prescription, date, professional, patient, prescriptiontype, dailydose, days, medicine,  studyrequired, diagnosis from prescription
