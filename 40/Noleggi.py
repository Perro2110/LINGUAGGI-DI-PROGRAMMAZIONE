class Noleggi:
    def __init__(self,CodiceVeicolo,NumeroGiorni,targa):
        self.CodiceVeicolo = CodiceVeicolo
        self.NumeroGiorni = NumeroGiorni
        self.targa = targa

    def getCodiceVeicolo(self):
        return self.CodiceVeicolo
    
    def getNumeroGiorni(self):
        return self.NumeroGiorni
    
    def __str__(self) -> str:
        return "("+str(self.targa) + ", "+str(self.NumeroGiorni)+")"
