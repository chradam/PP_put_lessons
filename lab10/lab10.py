import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
import seaborn as sns

from sklearn.datasets import load_boston
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error
from sklearn.metrics import mean_absolute_error

boston_dataset = load_boston()


def zad1():
    print(boston_dataset.keys())
    print(boston_dataset.feature_names)
    df = pd.DataFrame(data=boston_dataset.data, columns= boston_dataset.feature_names)

    df['MEDV'] = boston_dataset.target

    print(df.head(10))
    # print(df.tail(10))

    def zad2():
        df.info(verbose=False, null_counts=True)

    def zad3():
        # a) CRIM, mean=3.593761, std=8.596783
        # b) MEDV, max=50 tys. $, min= 5 tys. $
        # c) LSTAT, 50%=11.360000%
        print(df.describe(include = 'float'))

    def zad4():
        ax = sns.distplot(df['MEDV'])
        plt.show()

    def zad5():
        plt.figure(figsize=(7, 5))
        matrix = df.corr()
        mask = np.zeros_like(matrix)
        mask[np.triu_indices_from(mask)] = True
        # sns.heatmap(matrix, annot=True, fmt='.2f', mask=mask, annot_kws={"size": 7}, linewidths=2, linecolor='green')
        plt.show()
        # a) RM,
        # b) LSTAT, INDUS
        # c)

        df.plot(kind='scatter', x='MEDV', y='RM', alpha=0.4, color='green')
        plt.show()
        df.plot(kind='scatter', x='MEDV', y='LSTAT', alpha=0.4, color='blue')
        plt.show()
        df.plot(kind='scatter', x='MEDV', y='CHAS', alpha=0.4, color='pink')
        plt.show()

    def zad6():
        learning = df[['ZN', 'CHAS', 'RM', 'DIS', 'B', 'LSTAT']]
        label = df['MEDV']
        X_train, X_test, y_train, y_test = train_test_split(
            learning, label, test_size=0.2
        )
        print('X_train: {} | y_train: {}\nX_test: {} | y_test: {}'
              .format(len(X_train), len(y_train), len(X_test), len(y_test)))

        # zad7
        reg = LinearRegression().fit(X_train, y_train)

        # Make predictions using the training set
        y_pred_train = reg.predict(X_train)

        # Training plot outputs
        plt.scatter(y_train, y_pred_train, alpha=0.4, color='black')
        plt.show()

        # Make predictions using the testing set
        y_pred_test = reg.predict(X_test)
        # Test plot outputs
        plt.scatter(y_test, y_pred_test, alpha=0.4, color='blue')
        plt.show()

        # zad8
        # RMSE
        print("RMSE\ntrain: {}\ntest: {}"
              .format(mean_squared_error(y_train, y_pred_train),
                      mean_squared_error(y_test, y_pred_test)))

        # MAE
        print("MAE\ntrain: {}\ntest: {}"
              .format(mean_absolute_error(y_train, y_pred_train),
                      mean_absolute_error(y_test, y_pred_test)))





    # zad2()
    # zad3()
    # zad4()
    # zad5()
    zad6()

def main():
   zad1()

if __name__ == '__main__':
    main()