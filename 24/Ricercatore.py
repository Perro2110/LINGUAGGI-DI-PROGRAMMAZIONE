from Partecipazione import Partecipazione
class Ricercatore:
    def __init__(self,nome,cognome) -> None:
        self.nome    = nome
        self.cognome = cognome
        self.NumeroProgetti = 0
        self.impegnoOrario  = 0
        self.partecipazioni = []
        self.impiegoOrarioPiuAlto = 0
        self.codImpiegoOrarioMax = 0
    
    def setMassimi(self,impOrarMax,CodImpMax):
        self.impiegoOrarioPiuAlto = impOrarMax
        self.codImpiegoOrarioMax = CodImpMax
    
    def getInfoUtili(self):
        return self.nome+" "+self.cognome+" "+str(self.impiegoOrarioPiuAlto)+" "

    def getMaxCod(self):
        return self.codImpiegoOrarioMax

    def setNumeroProgetti (self,n):
        self.NumeroProgetti = n
    
    def setImpegnoOrario (self,n):
        self.impegnoOrario = n

    def addPartecipazione(self,p):
        self.partecipazioni.append(p)

    def getCognome(self):
        return self.cognome
    
    def __str__(self) -> str:
        return self.nome+" "+self.cognome+" "+str(self.impegnoOrario)+" "+str(self.NumeroProgetti)+str([str(i) for i in self.partecipazioni])
    