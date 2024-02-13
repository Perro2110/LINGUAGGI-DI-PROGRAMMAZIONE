from Prenotazioni import Prenotazioni
class Giocattori:
    def __init__(self,codice,nomeEcognome,eta,categoria) -> None:
        self.codice = codice
        self.nomeEcognome = nomeEcognome
        self.eta = eta
        self.categoria = categoria
        self.prenotazioni = []

    def __str__(self) -> str:
        return str(self.codice)+"\t"+self.nomeEcognome+"\t"+str(self.eta)+"\t"+str(self.categoria)+"\t"+str([str(i) for i in self.prenotazioni])
    
    def addPrenotazione(self,prenotazione):
        self.prenotazioni.append(prenotazione)
        