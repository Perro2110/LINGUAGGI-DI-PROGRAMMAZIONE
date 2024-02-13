class CorsiSeguiti:
    def __init__(self,cod,voto) -> None:
        self.cod  = cod
        self.voto = voto
    
    def getVoto(self):
        return self.voto
    
    def getCod(self):
        return self.cod

    def __str__(self) -> str:
        return str(self.cod)+ " "+str(self.voto)