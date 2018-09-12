# Load libraries
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


def visualize_data(dataset):
    # The Data
    print 'The Data -'
    print dataset
    print '-------------------------------'

    # head

    print (dataset.head(20))
    print '-------------------------------'

    # shape
    print 'Shape - ' + str(dataset.shape)
    print '-------------------------------'

    # descriptions
    print 'Describe'
    print(dataset.describe())
    print '-------------------------------'

    # class distribution
    print 'Class Distribution'
    print(dataset.groupby('class').size())
    print '-------------------------------'

    # box and whisker plots
    dataset.plot(kind='box', subplots=True, layout=(
        2, 2), sharex=False, sharey=False)
    plt.show()

    # Histogram
    dataset.hist()
    plt.show()

    # scatter plot matrix
    scatter_matrix(dataset)
    plt.show()

    return
