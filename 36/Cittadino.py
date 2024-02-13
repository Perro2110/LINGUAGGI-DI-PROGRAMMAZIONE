from SuperMercati import SuperMercati

class Cittadino(SuperMercati):
    def __init__(self, codice, tipo, indirizzo, superficie, numeroDiAddetti,orarioApertura,OrarioChiusura) -> None:
        super().__init__(codice, tipo, indirizzo, superficie, numeroDiAddetti)
        self.orarioApertura = orarioApertura
        self.OrarioChiusura = OrarioChiusura
    
    def __str__(self) -> str:
        return str(self.codice)+self.tipo+self.indirizzo+str(self.orarioApertura)+str(self.OrarioChiusura)+str(self.superficie)+str(self.numeroDiAddetti)+"-"