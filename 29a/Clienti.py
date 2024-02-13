from Servizi import Servizi
class Clienti:
    def __init__(self,codice,nomeCliente) -> None:
        self.codice = codice
        self.nomeCliente = nomeCliente
        self.totNumSer = 0
        self.servizi = []

    def setTot(self,totNumSer):
        self.totNumSer = totNumSer

    def addServizzio(self,servizio):
        self.servizi.append(servizio)
    
    def __str__(self) -> str:
        return str(self.codice)+" "+self.nomeCliente+" "+str(self.totNumSer)