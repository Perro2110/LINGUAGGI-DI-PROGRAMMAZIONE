from Impiegati import Impiegati 
class Guida (Impiegati):
    def __init__(self, cod, tipo, nomeDipendete, costoorario,telefono,conoscenzaInglese,appuntamentiSettimanali) -> None:
        super().__init__(cod, tipo, nomeDipendete, costoorario)
        self.telefono                = telefono
        self.conoscenzaInglese       = conoscenzaInglese
        self.appuntamentiSettimanali = appuntamentiSettimanali
    
    # nome, codice, tipo, ore settimanali, specialità, telefono,inglese, app.sett.,costo orario
    def __str__(self) -> str:
        return self.nomeDipendete+"\t"+str(self.cod)+"\t"+self.tipo+"\t"+"\t-"+"\t-\t"+str(self.telefono)+"\t"+self.conoscenzaInglese+"\t"+str(self.appuntamentiSettimanali)+"\t"+str(self.costoorario)
