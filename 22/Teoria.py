from Corsi import Corsi
class Teoria(Corsi):
    def __init__(self, codice, tipo, nomeDelCorso, nomeCognome,codAula,numeroOreSettimanali,numeroOrePerLezione) -> None:
        super().__init__(codice, tipo, nomeDelCorso, nomeCognome)
        self.codAula = codAula
        self.numeroOreSettimanali = numeroOreSettimanali
        self.numeroOrePerLezione  = numeroOrePerLezione
    
    def __str__(self) -> str:
        return self.nomeDelCorso+"\t"+str(self.codice)+"\t"+self.nomeCognome+"\t"+self.tipo+"\t"+str(self.codAula)+"\t"+str(self.numeroOreSettimanali)+"\t"+str(self.numeroOrePerLezione)+"\t"+"-"+"\t"+"-"+"\t"+"-"