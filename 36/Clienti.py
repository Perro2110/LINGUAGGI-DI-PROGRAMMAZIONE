from Visite import Visite
class Clienti:
    def __init__(self,cognome,nome) -> None:
        self.cognome = cognome
        self.nome = nome
        self.visite=[]
        self.spesaTotale = 0

    def addVisita(self,visita):
        self.visite.append(visita)

    def setSpesaTot(self,spesaTotale):
        self.spesaTotale=spesaTotale

    def __str__(self) -> str:
        return self.cognome +"\t"+ self.nome +"\t"+ str(self.spesaTotale)
