from Spettacoli import Spettacoli

class Serie(Spettacoli):
    def __init__(self, titolo, cod, tipo, produttore, anno,stagione,numeroDiPuntate) -> None:
        super().__init__(titolo, cod, tipo, produttore, anno)
        self.stagione        = stagione
        self.numeroDiPuntate = numeroDiPuntate
    
    def __str__(self) -> str:
        return self.tipo+"\t"+self.titolo+"\t"+str(self.cod)+"\t"+str(self.stagione)+"\t"+str(self.numeroDiPuntate)+"\t"+"-"+"\t"+str(self.anno)+"\t"+str(self.produttore)
