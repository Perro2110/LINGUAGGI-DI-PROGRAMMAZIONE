class Visite:
    def __init__(self,cod,importo) -> None:
        self.cod = cod
        self.importo = importo
    
    def __str__(self) -> str:
        return str(self.cod)+str(self.importo)