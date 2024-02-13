from Progetti import Progetti

class Innovazione(Progetti):
    def __init__(self, cod, tipo, titolo, nomeCognomeCoordinatore, organizzazione, importoTotaleInMilioniDiEuro,numeroAziendeCoinvolte) -> None:
        super().__init__(cod, tipo, titolo, nomeCognomeCoordinatore, organizzazione, importoTotaleInMilioniDiEuro)
        self.numeroAziendeCoinvolte = numeroAziendeCoinvolte


    #print("tipo, titolo, codice, coordinatore, organizzazione, argomento,partner, aziende, importo totale in migliaia di euro")  
    def __str__(self) -> str:
        return self.tipo+"\t"+self.titolo+"\t"+str(self.cod)+"\t"+self.nomeCognomeCoordinatore+"\t"+self.organizzazione+"\t"+"-"+"\t"+"-"+"\t"+str(self.numeroAziendeCoinvolte)+"\t"+str(self.importoTotaleInMilioniDiEuro)