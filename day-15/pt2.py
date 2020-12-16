# done in python because java couldn't handle it
spoken = [1,17,0,10,18,11,6]
lastspoken = {}
for i in range(len(spoken)):
  lastspoken[spoken[i]] = (i, -1)

for i in range(len(spoken), 30000000):
  last = spoken[i-1]
  if (last in lastspoken):
    pair = lastspoken[last]
    if (pair[0] != -1 and pair[1] != -1):
      res = pair[0] - pair[1]
      spoken.append(res)
      if (res in lastspoken):
        pair = lastspoken[res]
        lastspoken[res] = (i, pair[0])
      else:
        lastspoken[res] = (i, -1)
    else:
      spoken.append(0)
      if (0 in lastspoken):
        pair = lastspoken[0]
        lastspoken[0] = (i, pair[0])
      else:
        lastspoken[0] = (i, -1)
  else:
    spoken.append(0)
    pair = lastspoken[0]
    lastspoken[0] = (i, pair[0])
print(spoken[-1])