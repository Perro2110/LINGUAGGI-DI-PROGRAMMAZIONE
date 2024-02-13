class Noleggi:
    def __init__(self,codice,NumGiorni) -> None:
        self.codice       = codice
        self.NumeroGiorni = NumGiorni
    
    def __str__(self) -> str:
        return "("+str(self.codice) + " " + str(self.NumeroGiorni)+")" 