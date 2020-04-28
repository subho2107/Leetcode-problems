def change(S):
    res = ""
    for pos in range(0, len(S)):
        if S[pos] == '#' and pos-1 >= 0 and S[pos-1] != '#':
            res = res[0: len(res)-1]
        else:
            res += S[pos]
    return res

def backspaceCompare(S: str, T: str) -> bool:
    newS = change(S)
    newT = change(T)
    if newS == newT:
        return True
    else:
        return False

backspaceCompare()