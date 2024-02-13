from SuperMercati import SuperMercati

class Iper(SuperMercati):
    def __init__(self, codice, tipo, indirizzo, superficie, numeroDiAddetti,nomeCentro) -> None:
        super().__init__(codice, tipo, indirizzo, superficie, numeroDiAddetti)
        self.nomeCentro = nomeCentro

    def __str__(self) -> str:
        return str(self.codice)+self.tipo+self.indirizzo+"-"+"-"+str(self.superficie)+str(self.numeroDiAddetti)+self.nomeCentro