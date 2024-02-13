from Squadra import Squadra
class Hockey(Squadra):
    def __init__(self, cod, tipo, nomeSquadra, numPartiteVinte, numPartitePerse,nMedioDiGoal,nMedioFalli) -> None:
        super().__init__(cod, tipo, nomeSquadra, numPartiteVinte, numPartitePerse)
        self.nMedioDiGoal = nMedioDiGoal
        self.nMedioFalli  = nMedioFalli
    
    def __str__(self) -> str:
        return self.nomeSquadra+"\t"+str(self.cod)+"\t"+str(self.numPartiteVinte)+"\t"+str(self.numPartitePerse)+"\t"+str(self.nMedioDiGoal)+"\t"+str(self.nMedioFalli)+"\t"+"-\t"+self.tipo