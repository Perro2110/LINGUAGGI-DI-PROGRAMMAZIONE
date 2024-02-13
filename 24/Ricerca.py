from Progetti import Progetti

class Ricerca(Progetti):
    def __init__(self, cod, tipo, titolo, nomeCognomeCoordinatore, organizzazione, importoTotaleInMilioniDiEuro,codiceArgomento,numeroPartner) -> None:
        super().__init__(cod, tipo, titolo, nomeCognomeCoordinatore, organizzazione, importoTotaleInMilioniDiEuro)
        self.codiceArgomento = codiceArgomento
        self.numeroPartner   = numeroPartner

    #print("tipo, titolo, codice, coordinatore, organizzazione, argomento,partner, aziende, importo totale in migliaia di euro")  
    def __str__(self) -> str:
        return self.tipo+"\t"+self.titolo+"\t"+str(self.cod)+"\t"+self.nomeCognomeCoordinatore+"\t"+self.organizzazione+"\t"+str(self.codiceArgomento)+"\t"+str(self.numeroPartner)+"\t"+"-"+"\t"+str(self.importoTotaleInMilioniDiEuro)