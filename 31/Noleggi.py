class Noleggi:
    def __init__(self,cod,numGiorni) -> None:
        self.cod = cod 
        self.numGiorni = numGiorni
    def __str__(self) -> str:
        return str(self.cod)+" "+str(self.numGiorni)