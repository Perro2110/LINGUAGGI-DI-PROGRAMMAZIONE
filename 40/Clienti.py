from Noleggi import Noleggi
class Clienti:

    def __init__(self,nomeCognome):
        self.nomeCognome = nomeCognome
        self.noleggi = []
        self.volte=0
    
    def addNoleggi(self,noleggio):
        self.volte = self.volte +1 
        self.noleggi.append(noleggio)
    
    def getNomeCognome(self):
        return self.nomeCognome
    
    def getNoleggi(self):
        return self.noleggi
    
    def __str__(self) -> str:
        return str(self.volte)+" "+str([str(i) for i in self.noleggi])