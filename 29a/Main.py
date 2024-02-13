# 15.32  |       45      
# 16.17  |               
import sys
import argparse

from Dipendenti import Dipendenti
from Trainer import Trainer
from Nutrizionista import Nutrizionista
from Clienti import Clienti
from Servizi import Servizi

class Main:
    def __init__(self,arg):
        self._arg = arg
    
    def main(self):
        dipendenti = []
        clienti    = []
        CodCosto   = {}
        CodNome    = {}
        NomeNum    = {}

        try:
            f=open("dipendenti.txt","r")
            line = f.readline().strip()
            while(line != ''):
                tok  = line.split()
                cod  = int(tok[0])
                tipo = str(tok[1])
                line = f.readline().strip()
                nome = line
                if(tipo == "trainer"):
                    line = f.readline().strip()
                    tok = line.split()
                    ore = int(tok[0])
                    costoOrario = float(tok[1])
                    line = f.readline().strip()
                    specialita = line
                    d = Trainer(cod, tipo, nome, costoOrario,ore,specialita)
                if(tipo == "nutrizionista"):
                    line = f.readline().strip()
                    tok = line.split()     
                    telefono = int(tok[0])
                    medico   = str(tok[1])
                    appuntamentiSettimanali = int(tok[2])
                    costoOrario=float(tok[3])   
                    d = Nutrizionista(cod, tipo, nome, costoOrario,telefono,medico,appuntamentiSettimanali)
                dipendenti.append(d)
                CodCosto[cod] = costoOrario
                CodNome[cod]  = nome
                NomeNum[nome] = 0
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
                codice = int(line)
                line = f.readline().strip()
                nome = line
                c = Clienti(codice,nome)
                line = f.readline().strip()
                tot = 0
                while(line != ''):
                    tok = line.split()
                    cod    = int(tok[0])
                    numOre = float(tok[1])
                    s = Servizi(cod,numOre)
                    c.addServizzio(s)
                    tot=tot + (CodCosto[cod]*numOre)
                    NomeNum[CodNome[cod]]=NomeNum[CodNome[cod]]+1
                    line = f.readline().strip()
                c.setTot(tot)
                clienti.append(c)
                line = f.readline().strip()
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)

        print("nome, codice, tipo, ore settimanali, specialità, telefono, medico, app.sett., costo orario")
        for d in dipendenti:
            print(d)
        
        print("codice, il suo nome e il totale del costo dei servizi che ha utilizzato,")
        for c in clienti:
            print(c)
        
        max = -1
        for d in dipendenti:
            if(NomeNum[d.getNome()] > max):
                NomeMagg = d.getNome()
                max = NomeNum[d.getNome()]

        print(NomeMagg + " "+str(max))


if __name__ == "__main__":
    g= Main(sys.argv)
    g.main()