class Prenotazioni:
    def __init__(self,campo,inizio) -> None:
        self.campo  = campo 
        self.inizio = inizio
    
    def __str__(self) -> str:
        return str(self.campo)+str(self.inizio)