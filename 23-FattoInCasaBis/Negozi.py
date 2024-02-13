from Elemento import Elemento 
class Negozi:
    def __init__(self,cod,nome,indirizzo) -> None:
        self.cod = cod
        self.nome = nome
        self.indirizzo = indirizzo
        self.elementi = []
        self.numArticoli = 0
    
    def addElemento(self,elemento):
        self.elementi.append(elemento)
        self.numArticoli = self.numArticoli + 1 
    
    def __str__(self) -> str:
        return str(self.cod)+"\t"+self.nome+"\t"+self.indirizzo+"\t"+str(self.numArticoli)+"\t"+str([str(i) for i in self.elementi])
