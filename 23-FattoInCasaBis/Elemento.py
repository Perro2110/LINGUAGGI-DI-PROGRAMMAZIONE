class Elemento:
    def __init__(self,cod,quantita) -> None:
        self.cod      = cod
        self.quantita = quantita
    
    def __str__(self) -> str:
        return str(self.cod) + " " + str(self.quantita)