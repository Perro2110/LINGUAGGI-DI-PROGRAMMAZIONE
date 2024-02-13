class Giocatori:
    def __init__(self,codSquadra,cognome,nome,eta,numMaglia,ruolo,titolare,nomeSquadra) -> None:
        self.codSquadra = codSquadra
        self.cognome = cognome
        self.nome = nome
        self.eta = eta 
        self.numMaglia = numMaglia
        self.ruolo = ruolo 
        self.titolare = titolare
        self.nomeSquadra = nomeSquadra 
    
    def __str__(self) -> str:
        return self.nome +"\t"+ self.cognome +"\t"+ str(self.eta)+"\t"+ str(self.numMaglia)+"\t"+ self.ruolo+"\t"+ self.titolare+"\t"+ self.nomeSquadra