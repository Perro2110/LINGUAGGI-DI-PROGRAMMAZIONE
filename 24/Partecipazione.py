class Partecipazione:
    def __init__(self,cod,impegnoOrario) -> None:
        self.cod = cod
        self.impegnoOrario = impegnoOrario
    
    def __str__(self) -> str:
        return str(self.cod)+" "+str(self.impegnoOrario)