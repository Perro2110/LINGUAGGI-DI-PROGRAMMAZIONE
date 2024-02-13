from Noleggi import Noleggi
class Clienti:
    def __init__(self,cognomeNome) -> None:
        self.cognomeNome = cognomeNome
        self.noleggi=[]
        self.CostoMax = 0
        self.numNoleggi = 0
    
    def incnumNoleggi(self):
        self.numNoleggi += 1
    
    def getCostoMax (self):
        return self.CostoMax

    def setCostoMax (self,costoNuovo):
        self.CostoMax = costoNuovo

    def addNoleggio(self,noleggio):
        self.noleggi.append(noleggio)

    def __str__(self) -> str:
        return self.cognomeNome +"\t"+str(self.CostoMax)+"\t"+str(self.numNoleggi)

