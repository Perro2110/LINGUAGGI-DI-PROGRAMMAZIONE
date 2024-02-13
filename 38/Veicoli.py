
class Veicoli:
    def __init__(self,codice,tipo,marcaDelVeicolo,lunghezza,largezza,costoGiornaliero,postiLetto) -> None:
        self.codice = codice
        self.tipo = tipo
        self.marcaDelVeicolo = marcaDelVeicolo
        self.lunghezza = lunghezza
        self.largezza = largezza
        self.costoGiornaliero =costoGiornaliero        
        self.postiLetto = postiLetto
    
    def getCod(self):
        return self.codice