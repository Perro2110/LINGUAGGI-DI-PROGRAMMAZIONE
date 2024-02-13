class Clienti:
    def __init__(self,codice,nome,cognome,indirizzo) -> None:
        self.codice    = codice
        self.nome      = nome
        self.cognome   = cognome
        self.indirizzo =indirizzo
        self.noleggi = []
    
    def addNoleggi(self,noleggio):
        self.noleggi.append(noleggio) 

        print("codice, cognome, nome, indirizzo, prenotazioni")
    def __str__(self) -> str:
        return str(self.codice)+"\t"+self.cognome+"\t"+self.nome+"\t"+self.indirizzo+" "+str([str(i) for i in self.noleggi])