from CorsiSeguiti import CorsiSeguiti
class Studenti:
    def __init__(self,matricola,nomeECognome) -> None:
        self.matricola    = matricola
        self.nomeECognome = nomeECognome
        self.libretto     = []
        self.numeroEsamiDati = 0
        self.numeroVotoEffettivo = 0
        self.votoMagg = 0
        self.CodCorsoVotoMagg = 0
    
    def addCorsiSeguiti(self,corsoSeguito):  # NB CORSO SEGUITO E CLASSE
        self.libretto.append(corsoSeguito)
        self.numeroEsamiDati = self.numeroEsamiDati +1
        if(corsoSeguito.getVoto() == "30L"):
            voto = 31
        else:
            voto = int(corsoSeguito.getVoto())
        self.numeroVotoEffettivo = self.numeroVotoEffettivo + voto

        if(voto > self.votoMagg):
            self.votoMagg = voto
            self.CodCorsoVotoMagg = corsoSeguito.getCod()

    
    def __str__(self) -> str:
        return  self.nomeECognome+" "+str(self.matricola)+str(self.numeroVotoEffettivo/self.numeroEsamiDati)+" "+str([str(i) for i in self.libretto])
    
    def getMatricola(self):
        return self.matricola
    
    def getVotoMagg(self):
        if(self.votoMagg == 31):
            return "30L"
        else: 
            return str(self.votoMagg)

    
    def getCodCorsoVotoMagg(self):
        return self.CodCorsoVotoMagg
    
    def getNome(self):
        return self.nomeECognome