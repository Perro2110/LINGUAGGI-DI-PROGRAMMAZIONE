from Squadra import Squadra
class Pallamano(Squadra):
    def __init__(self, cod, tipo, nomeSquadra, numPartiteVinte, numPartitePerse,nMedioDiReti) -> None:
        super().__init__(cod, tipo, nomeSquadra, numPartiteVinte, numPartitePerse)
        self.nMedioDiReti = nMedioDiReti
    
        #nome della squadra, codice, n. partite vinte, n. partite perse,n. medio di gol, n. medio di falli, n. medio di reti, sport
    
    def __str__(self) -> str:
        return self.nomeSquadra+"\t"+str(self.cod)+"\t"+str(self.numPartiteVinte)+"\t"+str(self.numPartitePerse)+"\t"+"-"+"\t"+"-"+"\t"+str(self.nMedioDiReti)+"\t"+self.tipo