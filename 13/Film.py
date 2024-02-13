from Spettacoli import Spettacoli

class Film(Spettacoli):
    def __init__(self, titolo, cod, tipo, produttore, anno,Durata) -> None:
        super().__init__(titolo, cod, tipo, produttore, anno)
        self.Durata = Durata
    
    def __str__(self) -> str:
        return self.tipo+"\t"+self.titolo+"\t"+str(self.cod)+"\t"+"-"+"\t"+"-"+"\t"+str(self.Durata)+"\t"+str(self.anno)+"\t"+str(self.produttore)


    