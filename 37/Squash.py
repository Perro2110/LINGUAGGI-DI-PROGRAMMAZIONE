from Campi import Campi

class Squash(Campi):
    def __init__(self, codice, tipo, nomeCampo, larghezza, lunghezza, costoOrario,altezzaInMetri,piano) -> None:
        super().__init__(codice, tipo, nomeCampo, larghezza, lunghezza, costoOrario)
        self.altezzaInMetri = altezzaInMetri
        self.piano = piano
 
    def __str__(self) -> str:
        return self.tipo+"\t" + self.nomeCampo+"\t" + str(self.codice)+"\t" + str(self.larghezza)+"\t" + str(self.lunghezza) + "\t-\t" + "-" + str(self.altezzaInMetri)+"\t" + str(self.piano) +"\t"+ str(self.costoOrario)
    
