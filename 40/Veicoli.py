class Veicoli:

    def __init__(self,codice,tipo,targa,modello,marca,costoGiornaliero):
        self.codice = codice
        self.tipo = tipo
        self.targa = targa
        self.modello = modello
        self.marca = marca
        self.costoGiornaliero = costoGiornaliero

    def getCostoGiorno(self):
        return self.costoGiornaliero
    
    def getCodiceVeicolo(self):
        return self.codice
    
    def getTarga(self):
        return self.targa
