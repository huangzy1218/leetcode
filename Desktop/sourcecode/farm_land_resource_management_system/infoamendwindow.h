#ifndef INFOAMENDWINDOW_H
#define INFOAMENDWINDOW_H

#include <QWidget>

namespace Ui {
class InfoAmendWindow;
}

class InfoAmendWindow : public QWidget
{
    Q_OBJECT

public:
    explicit InfoAmendWindow(QWidget *parent = nullptr);
    ~InfoAmendWindow();

private:
    Ui::InfoAmendWindow *ui;
};

#endif // INFOAMENDWINDOW_H
