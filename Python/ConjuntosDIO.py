cnjt = {1,2,3,4,5}
cnjt2 = {5,6,7,8}
print(type(cnjt))
print(cnjt)

uCnjt = cnjt.union(cnjt2)
print(uCnjt)
iCnjt = cnjt.intersection(cnjt2)
print(iCnjt)
dCnjt = cnjt2.difference(cnjt)
print(dCnjt)
dsCnjt = cnjt.symmetric_difference(cnjt2)
print(dsCnjt)

cnjtA = cnjt
cnjtB = cnjt2

cnjtSuper = cnjtB.issuperset(cnjtA)
cnjtSub = cnjtB.issubset(cnjtA)
print('A = {} \nB = {}'.format(cnjtA,cnjtB))
print('A Sub={} Super={} '.format(cnjtSub,cnjtSuper))



'''
adicionar e remover itens de conjuntos
    add()
    discard()
'''