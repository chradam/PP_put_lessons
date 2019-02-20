from functools import reduce
import string
import collections


def zad1(numbers):
    def increment(numbers):
        return (numbers[x]+1 for x in range(len(numbers)))
    print('[', end='')
    for pos in increment(numbers):
       print(pos, ' ', end='')
    print(']')


def zad2(numbers):
    print(reduce(lambda x,y: x*y, numbers))


def zad3(text):
    def reverse(t):
        return t[::-1]

    def to_lower(t):
        return t.lower()

    def only_alpha(t):
        return ''.join(filter(str.isalpha, t))

    def is_palindrom(t):
        rev = reverse(t)
        if t == rev:
            print(True)
        else:
            print(False)

    tL = to_lower(text)
    only_alpha(tL)
    is_palindrom(tL)


def zad4(text):
    def to_lower(t):
        return t.lower()

    def delete_punctuation(t):
        exclude = set(string.punctuation)
        exclude.add('—')
        exclude.add('\n')
        exclude.remove('-')
        t = list(filter(lambda l: l not in exclude, t))
        for (i, item) in enumerate(t):
            if item == '-':
                t[i] = ' '
        return ''.join(t)

    def split_by_space(t):
        t = t.split(' ')
        return list(filter(None, t)) # delete empty containers, ex. '', []

    def tokenize(text):
        tL = to_lower(text)
        tL = delete_punctuation(tL)
        tL = split_by_space(tL)
        return tL

    tokens = tokenize(text)
    print(tokens)
    return tokens


def zad5(text, path=''):
    with open("pl.stopwords.txt", encoding='windows-1250') as stop_words_file:
        stop_words = stop_words_file.read()
    if len(path) > 1:
        with open(path, encoding='windows-1250') as input_file:
            text = input_file.read()

    def remove_stop_words(tokens):
        return [tok for tok in tokens if tok not in stop_words and len(tok) > 1]

    tokens = zad4(text)
    removed = remove_stop_words(tokens)
    print(removed)
    return removed


def zad6(file_path):
    words = zad5('',file_path)
    c = collections.Counter(words)
    print("20 most common words: ", c.most_common(20))


def zad7(file_path):
    sort_words = {}
    anagrams = []

    with open(file_path, encoding='UTF-8') as input_file:
        text = input_file.read()
        tokens = text.split('\n')
        for word in tokens:
            sort_words[word] = ''.join(sorted(word))
    max_now = 0
    max_prev = 0
    current = 0
    for i in range(len(tokens)):
        ana = [tokens[i]]
        for j in range(i + 1, len(tokens)):
            if sort_words[tokens[i]] == sort_words[tokens[j]]:
                ana.append(tokens[j])
                max_now = max(max_now, len(tokens[j]))
                current = len(tokens[j])


        if len(ana) != 1 and max_prev != max_now:
            anagrams.clear()
            anagrams.append(ana)
            max_prev = max_now
        elif len(ana) != 1 and max_now == current:
            anagrams.append(ana)

    print(anagrams)


if __name__ == "__main__":
    print("zad1")
    zad1([1,2,3,4])
    print("zad2")
    zad2([1,2,3,4])
    print("zad3")
    zad3("Tolo ma samolot")
    print("zad4")
    zad4("To be, or not to be - that is the question [...]")
    print("zad5")
    zad5("Ależ że to musiało boleć kiedy spadłaś z nieba, aj a y y q")
    print("zad6")
    zad6("trurl.txt")
    print("zad7")
    zad7("unixdict.txt")