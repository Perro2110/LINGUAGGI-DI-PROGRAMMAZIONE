
class Dipendenti:
    def __init__(self,cod,tipo,nome,costoOrario) -> None:
        self.cod  = cod
        self.tipo = tipo
        self.nome = nome
        self.costoOrario = costoOrario        
    
    def getNome(self):
        return self.nome