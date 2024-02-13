from Servizi import Servizi 
class Visitatori:
    def __init__(self,cod,nome) -> None:
        self.cod  = cod
        self.nome = nome
        self.servizi = []
    
    def addServizio(self,servizio):
        self.servizi.append(servizio) 
    
    def __str__(self) -> str:
        return str(self.cod)+"\t"+self.nome+"\t"+str([str(i) for i in self.servizi])

            