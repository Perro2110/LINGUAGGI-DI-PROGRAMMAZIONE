from Corsi import Corsi
class Laboratorio(Corsi):
    def __init__(self, codice, tipo, nomeDelCorso, nomeCognome,nomeLaboratorio,nomeAssistente,nummeroPostazioniNelLaboratorio) -> None:
        super().__init__(codice, tipo, nomeDelCorso, nomeCognome)
        self.nomeLaboratorio                 = nomeLaboratorio
        self.nomeAssistente                  = nomeAssistente
        self.nummeroPostazioniNelLaboratorio = nummeroPostazioniNelLaboratorio

        # nome, codice, docente, tipo, aula, ore sett., ore/lez., lab.,assistente, postazioni
    def __str__(self) -> str:
        return self.nomeDelCorso+"\t"+str(self.codice)+"\t"+self.nomeCognome+"\t"+self.tipo+"\t"+"-"+"\t"+"-"+"\t-\t"+self.nomeLaboratorio+"\t"+self.nomeAssistente+"\t"+str(self.nummeroPostazioniNelLaboratorio)