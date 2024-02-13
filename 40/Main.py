import sys
import argparse


from Veicoli import Veicoli
from Clienti import Clienti
from Noleggi import Noleggi
from Auto import Auto
from Furgone import Furgone


class Main:
    def __init__(self,arg):
        self._arg = arg
    
    def main(self):
        vveicoli = []
        vclienti = []
        CodiceCosto = {} # Avrei potuto fare CodiceMacchina ma prefersico per maggior modularita di programmazione
        CodiceVolte = {} # strutturata la gestione di due diverse map


        try:
            f=open("veicoli.txt","r")
            line = f.readline().strip()
            while(line != ''):
                tok = line.split()
                codice =int(tok[0])
                tipo   =str(tok[1])
                targa  =str(tok[2])
                line = f.readline().strip()
                modello = line
                line = f.readline().strip()
                marca = line
                if(tipo == "auto"):
                    line = f.readline().strip()
                    tok = line.split()
                    cilindrata = int(tok[0])
                    CapienzaBagagliaio = float(tok[1])
                    line = f.readline().strip()
                    costoGiornaliero = float(line)
                    v = Auto(codice, tipo, targa, modello, marca, costoGiornaliero,cilindrata,CapienzaBagagliaio)
                if(tipo == "furgone"):
                    line = f.readline().strip()
                    categoria = str(line)
                    line = f.readline().strip()  
                    tok = line.split()
                    numPosti = int(tok[0])
                    vanoDiCarico = bool(tok[1])
                    line = f.readline().strip()
                    costoGiornaliero = float(line)
                    v = Furgone(codice, tipo, targa, modello, marca, costoGiornaliero,categoria,numPosti,vanoDiCarico)
                
                CodiceCosto[codice] = costoGiornaliero
                CodiceVolte[codice] = 0
                vveicoli.append(v) 
                line = f.readline().strip() 
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)

        try:
            f=open("clienti.txt","r")
            line = f.readline().strip()
            while(line != ''):
                NomeeCognome = line
                c = Clienti(NomeeCognome)
                line = f.readline().strip() 
                tok = line.split()
                for i in range(len(tok)//2):
                    cod=int(tok[i*2])
                    NumGiorni=int(tok[i*2+1])
                    CodiceVolte[cod]=CodiceVolte[cod]+NumGiorni                    
                    targa = "////"
                    for v in vveicoli:
                        if v.getCodiceVeicolo() == cod:
                            targa = v.getTarga()
                    n=Noleggi(cod,NumGiorni,targa)
                    c.addNoleggi(n)
                vclienti.append(c)  
                line = f.readline().strip()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)

        print("tipo, targa, codice, modello, marca, costo giornaliero,cilindrata, bagagliaio, categoria, numero di posti, vano di carico")
        for v in vveicoli:
            print(v)
        
        print()
        
        for c in vclienti:
            tot = 0
            for nol in c.getNoleggi():
                for v in vveicoli:
                    if nol.getCodiceVeicolo() == v.getCodiceVeicolo():
                        tot += v.costoGiornaliero * nol.getNumeroGiorni()
            print(c.getNomeCognome()," ",tot,c)
       
        print(CodiceCosto[int(sys.argv[1])]*CodiceVolte[int(sys.argv[1])])

if __name__ == "__main__":
    g= Main(sys.argv)
    g.main()