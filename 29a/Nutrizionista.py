from Dipendenti import Dipendenti
class Nutrizionista(Dipendenti):
    def __init__(self, cod, tipo, nome, costoOrario,telefono,medico,appuntamentiSettimanali) -> None:
        super().__init__(cod, tipo, nome, costoOrario)
        self.telefono = telefono
        self.medico   = medico
        self.appuntamentiSettimanali = appuntamentiSettimanali

    def __str__(self) -> str:
        return self.nome+"\t"+str(self.cod)+"\t"+self.tipo+"\t"+"-"+"\t"+"-"+"\t"+str(self.telefono)+"\t"+self.medico+"\t"+str(self.appuntamentiSettimanali)+str(self.costoOrario)