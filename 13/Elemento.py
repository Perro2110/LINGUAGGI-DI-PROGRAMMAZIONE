class Elemento:
    def __init__(self,cod,titolo,tipo) -> None:
        self.cod = cod
        self.titolo = titolo
        self.tipo = tipo
    
    def __str__(self) -> str:
        return self.titolo+" "+self.tipo
        