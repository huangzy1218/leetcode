#ifndef AMENDPERSONWINDOW_H
#define AMENDPERSONWINDOW_H

#include <QWidget>

namespace Ui {
class AmendPersonWindow;
}

class AmendPersonWindow : public QWidget
{
    Q_OBJECT

public:
    explicit AmendPersonWindow(QWidget *parent = nullptr);
    ~AmendPersonWindow();

private:
    Ui::AmendPersonWindow *ui;
};

#endif // AMENDPERSONWINDOW_H
