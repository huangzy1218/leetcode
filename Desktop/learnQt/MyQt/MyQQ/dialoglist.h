#ifndef DIALOGLIST_H
#define DIALOGLIST_H

#include <QWidget>

namespace Ui {
class DiaLogList;
}

class DiaLogList : public QWidget
{
    Q_OBJECT

public:
    explicit DiaLogList(QWidget *parent = nullptr);
    ~DiaLogList();

private:
    Ui::DiaLogList *ui;
};

#endif // DIALOGLIST_H
