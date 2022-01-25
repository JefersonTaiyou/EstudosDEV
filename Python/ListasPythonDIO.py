lst = ['index0','index1','index2']
print(type(lst))
print(lst)
print(len(lst))
for i in range(len(lst)):
    print(lst[i])

aux = 'INDEX3'
if aux.lower() in lst:
    print('{} já em list'.format(aux))
else:
    lst.append(aux.lower())

print(lst)

'''
Para adicionar itens a lista >>> append
para remover itens da lista >>>> 
    pop() - remove por padrão o ultimo registro ou uma posição especifica  ex: pop(2)
    remove() - remove um registro especifico da lista  ex: remove('teste')
'''

#Diferença de tupla e lista
'''
Uma lista pode ser variada no decorrer da programação
Já uma tupla quando definida, é imutavel o seu registro

tupla = ()
lista = []

*conversores
    tupla(lst)
    list(tpl)
'''

