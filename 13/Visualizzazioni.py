from Elemento import Elemento
class Visualizzazioni:
    def __init__(self,codU,nome,cognome) -> None:
        self.codU    = codU
        self.nome    = nome
        self.cognome = cognome
        self.numSpett= 0
        self.elementi = []
    
    def addElemento(self,elemento):
        self.elementi.append(elemento)
        self.numSpett = self.numSpett +1
    
    def str2(self):
        return self.nome +" "+ self.cognome +" "+ str(self.numSpett)
    
    
    def __str__(self) -> str:
        return self.nome+" "+self.cognome+"\t"+str([str(i) for i in self.elementi])