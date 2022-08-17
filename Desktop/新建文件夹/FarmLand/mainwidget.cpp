#include "mainwidget.h"

MainWidget::MainWidget(QObject *parent)
    : QAbstractItemModel(parent)
{
}

QVariant MainWidget::headerData(int section, Qt::Orientation orientation, int role) const
{
    // FIXME: Implement me!
}

QModelIndex MainWidget::index(int row, int column, const QModelIndex &parent) const
{
    // FIXME: Implement me!
}

QModelIndex MainWidget::parent(const QModelIndex &index) const
{
    // FIXME: Implement me!
}

int MainWidget::rowCount(const QModelIndex &parent) const
{
    if (!parent.isValid())
        return 0;

    // FIXME: Implement me!
}

int MainWidget::columnCount(const QModelIndex &parent) const
{
    if (!parent.isValid())
        return 0;

    // FIXME: Implement me!
}

QVariant MainWidget::data(const QModelIndex &index, int role) const
{
    if (!index.isValid())
        return QVariant();

    // FIXME: Implement me!
    return QVariant();
}
