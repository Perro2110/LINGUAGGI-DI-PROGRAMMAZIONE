from Campi import Campi

class Tennis(Campi):
    def __init__(self, codice, tipo, nomeCampo, larghezza, lunghezza, costoOrario,tempMedia,terreno) -> None:
        super().__init__(codice, tipo, nomeCampo, larghezza, lunghezza, costoOrario)
        self.tempMedia = tempMedia
        self.terreno   = terreno

    def __str__(self) -> str:
        return self.tipo+"\t"+self.nomeCampo+"\t"+str(self.codice)+"\t"+str(self.larghezza)+"\t"+str(self.lunghezza)+"\t"+str(self.tempMedia)+"\t"+self.terreno+"\t-"+"\t-\t"+str(self.costoOrario)
    