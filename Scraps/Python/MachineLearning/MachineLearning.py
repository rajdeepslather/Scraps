# Load libraries
import sys
sys.path.append("D:\\GitRepo\\Scraps\\Python\\MachineLearning")

import visualize as viz
import matplotlib.pyplot as plt
import pandas
from pandas.plotting import scatter_matrix
from sklearn import model_selection
from sklearn.discriminant_analysis import LinearDiscriminantAnalysis
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import (
    accuracy_score, classification_report, confusion_matrix)
from sklearn.naive_bayes import GaussianNB
from sklearn.neighbors import KNeighborsClassifier
from sklearn.svm import SVC
from sklearn.tree import DecisionTreeClassifier


def get_dataset():
    url = "D:\\GitRepo\\Scraps\\Python\\MachineLearning\\Data\\irisDataSet.csv"
    names = ['sepal-length', 'sepal-width',
             'petal-length', 'petal-width', 'class']
    dataset = pandas.read_csv(url, names=names)
    return dataset


def split_dataset(dataset):
    # Split-out validation dataset
    array = dataset.values
    X = array[:, :-1]
    Y = array[:, -1]
    return X, Y


def get_models():
    models = []
    models.append(('LR', LogisticRegression()))
    models.append(('LDA', LinearDiscriminantAnalysis()))
    models.append(('KNN', KNeighborsClassifier()))
    models.append(('CART', DecisionTreeClassifier()))
    models.append(('NB', GaussianNB()))
    models.append(('SVM', SVC()))
    return models


def test_with_validation_data(model, X_train, Y_train, X_validation, Y_validation):
    model.fit(X_train, Y_train)
    predictions = model.predict(X_validation)
    print(accuracy_score(Y_validation, predictions))
    print(confusion_matrix(Y_validation, predictions))
    print(classification_report(Y_validation, predictions))


def main():
    dataset = get_dataset()
    # viz.visualize_data(dataset)

    X, Y = split_dataset(dataset)

    validation_size = 0.20
    seed = 7

    X_train, X_validation, Y_train, Y_validation = model_selection.train_test_split(
        X, Y, test_size=validation_size, random_state=seed)

    # Test options and evaluation metric
    scoring = 'accuracy'

    # Spot Check Algorithms

    models = get_models()

    # evaluate each model in turn
    # TODO find out how to do n_jobs=8
    results = []
    names = []
    for name, model in models:
        kfold = model_selection.KFold(n_splits=10, random_state=seed)
        cv_results = model_selection.cross_val_score(
            model, X_train, Y_train, cv=kfold, scoring=scoring, n_jobs=1)
        results.append(cv_results)
        names.append(name)
        msg = "%s: %f (%f)" % (name, cv_results.mean(), cv_results.std())
        print(msg)

    # Compare Algorithms
    fig = plt.figure()
    fig.suptitle('Algorithm Comparison')
    ax = fig.add_subplot(111)
    plt.boxplot(results)
    ax.set_xticklabels(names)
    plt.show()

    test_with_validation_data(
        KNeighborsClassifier(), X_train, Y_train, X_validation, Y_validation)

    test_with_validation_data(
        SVC(), X_train, Y_train, X_validation, Y_validation)
    return


if __name__ == '__main__':
    main()
